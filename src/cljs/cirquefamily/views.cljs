(ns cirquefamily.views
    (:require [re-frame.core :as re-frame]
              [garden.color :as gc]
              [cirquefamily.colors :as c]))

;; --------------------
(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      (let [background-color (re-frame/subscribe [:background-color])]
        [:svg
         (when @background-color {:style {:background-color (gc/as-hex @background-color)}})
         [:circle.bullseye
          {:cx 120 :cy 120 :r 12.5
           :on-click #(re-frame/dispatch [:change-background c/light-blue])}]
         [:circle.inner
          {:cx 120 :cy 120 :r 35
           :on-click #(re-frame/dispatch [:change-background c/blue])}]
         [:circle.central
          {:cx 120 :cy 120 :r 65
           :on-click #(re-frame/dispatch [:change-background c/orange])}]
         [:circle.outer
          {:cx 120 :cy 120 :r 95
           :on-click #(re-frame/dispatch [:change-background c/green])}]
         [:circle.bullseye.band
          {:cx 120 :cy 120 :r 22.5}]]))))

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
