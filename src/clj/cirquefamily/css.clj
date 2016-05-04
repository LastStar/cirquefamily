(ns cirquefamily.css
  (:refer-clojure :exclude [+ - * / rem])
  (:require [garden.units :as u :refer [px rem vh vw s]]
            [cirquefamily.colors :as c]
            [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]))

(defn scale [magnitude]
  (str "scale(" magnitude ")"))

(defkeyframes zoom-in
  [:0% {:transform (scale 0.9)
        :opacity 0.1}]
  [:50% {:transform (scale 2.1)
         :opacity 1}]
  [:100% {:transform (scale 2.1)
         :opacity 1}])

(defkeyframes reveal
  [:0% {:opacity 0.1}]
  [:100% {:opacity 1}])

(defkeyframes pulse
  [:0% {:transform (scale 1)}]
  [:90% {:transform (scale 1)}]
  [:96% {:transform (scale 1.14)}]
  [:100% {:transform (scale 1.04)}])

(def breath-time (u/s 1.62))

(defstyles screen
  zoom-in
  reveal
  pulse
  [:html
   {:font-size (u/px 14)}]
  [:body :.ui.button :.ui.input>input
   {:font-family "Vegan Sans"}]
  [:#last :#first
   {:font-weight 900}]
  [:body
   {:margin 0
    :font-size (u/rem 1)
    :background-color "#020202"
    :transition [[:background-color (* 3 breath-time) :ease-out]]}
   [:&.light
    {:background-color :white}
    [:header.ui.centered.grid>h1.ui.header
     {:color :black}]
    [:footer
     {:color :black}]]
  [:header.ui.centered.grid
   {:padding [[(u/rem 4) 0]]}
   [:h1.ui.header
    {:transition [[:color (* 3 breath-time) :ease-out]]
     :animation [[reveal (* 2 breath-time) :ease :forwards]]
     :font-family "VeganSuperiorMBL-Bold"
     :font-variant-caps :small-caps
     :color "#FDFDFD"
     :font-size "101.75px"}]]
  [:main
   {:text-align :center
    :margin-bottom (u/rem 2)}
   [:svg
    {:animation [[zoom-in (* 2 breath-time) 1 :ease :forwards]]
     :margin [[(u/rem 12) 0 (u/rem -1)]]
     :padding "0px !important"}
    [:#text :#CF
     {:cursor :pointer}]
    [:#CF.initial
     {:animation [[pulse (* 2 breath-time) :ease :infinite :alternate]]
      :transform-origin :center}]]
   [:div.subscribe
    {:animation [[reveal breath-time :ease :forwards]]}
    [:&>form>div
     {:text-align :center}]]
   [:div.parents
    {:animation [[reveal breath-time :ease :forwards]]
     :justify-content :space-around}
    [:img
     {:-webkit-filter "grayscale(70%)"}
     [:&:hover
      {:-webkit-filter "grayscale(0%)"}]]]
   [:.ui.cards:after :.ui.card:after
    {:display :none}]]
  [:footer
   {:font-family "VeganSuperiorMBL-Bold"
    :font-variant-caps :small-caps
    :position :fixed
    :right (u/rem 2)
    :bottom (u/rem 1)
    :color "#FDFDFD"}]])
