(ns cirquefamily.views
    (:require [re-frame.core :as frame]
              [re-frame.utils :as utils]
              [garden.color :as gc]
              [cirquefamily.svg :as svg]))

(defn home-panel []
  (let [part @ (frame/subscribe [:part])
        background (gc/as-hex @ (frame/subscribe [:home-color]))]
    [:div.ui.container
     [:header.ui.centered.grid
      [:h1.ui.ten.wide.header "Cirque Family"]]
     [:main.ui.centered.grid
       [svg/logo]]
     [:footer.ui.centered.grid.footer "\u00A9 Cirque Family 2016"]]))

;; main
(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (frame/subscribe [:active-panel])]
    (fn []
       (panels @active-panel))))
