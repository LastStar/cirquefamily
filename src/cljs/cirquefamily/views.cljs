(ns cirquefamily.views
    (:require [re-frame.core :as re-frame]))

;; --------------------
(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:svg
       [:circle.bullseye
        {:cx 120 :cy 120 :r 15}]
       [:circle.inner
        {:cx 120 :cy 120 :r 45}]
       [:circle.outer
        {:cx 120 :cy 120 :r 75}]])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href "#/"} "go to Home Page"]]]))

;; --------------------
(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      (panels @active-panel))))
