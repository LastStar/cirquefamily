(ns cirquefamily.views
    (:require [re-frame.core :as frame]
              [re-frame.utils :as utils]
              [garden.color :as gc]
              [re-com.core :as com]
              [cirquefamily.svg :as svg]))

(defn home-panel []
  (let [background (gc/as-hex @ (frame/subscribe [:home-color]))]
    [com/v-box
     :class "content"
     :children [(svg/home background)]]))

(defn about-title []
  [com/title
   :label "About Cirque Family."
   :level :level1])

(defn about-panel []
  [com/v-box
   :class "content"
   :gap "1em"
   :children [[about-title]]])

;; components

(defn title [background]
  (let [name (frame/subscribe [:name])]
      [:h1
       {:style {:color background}}
       @name]))

(defn link-to-home-page [background]
  [com/hyperlink-href
   :label "Home"
   :href "#/"
   :style {:color background}])

(defn link-to-about-page [background]
  [com/hyperlink-href
   :label "About"
   :href "#/about"
   :style {:color background}])

(defn navigation [background]
    [com/h-box
     :size "1"
     :class "navigation"
     :justify :between
     :children
     [[link-to-home-page background]
      [com/label
       :style {:color background}
       :label "|"]
      [link-to-about-page background]]])

(defn header []
  (let [background (gc/as-hex @ (frame/subscribe [:home-color]))]
  [com/h-box
   :class "header"
   :justify :between
   :align :center
   :children [[title background]
              [navigation background]]]))

;; main

(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (frame/subscribe [:active-panel])]
    (fn []
      [com/v-box
       :height "100%"
       :children [[header]
                  (panels @active-panel)]])))
