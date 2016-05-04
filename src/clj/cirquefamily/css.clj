(ns cirquefamily.css
  (:refer-clojure :exclude [+ - * / rem])
  (:require [garden.units :as u :refer [px rem vh vw s]]
            [cirquefamily.colors :as c]
            [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]
            [garden.stylesheet :refer [at-media]]))

(defn scale [magnitude]
  (str "scale(" magnitude ")"))

(defkeyframes zoom-in
  [:0% {:transform (scale 0.7)
        :opacity 0.1}]
  [:50% {:transform (scale 1.9)
         :opacity 1}]
  [:100% {:transform (scale 1.9)
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
  [:body :.ui.button :.ui.input>input :h4 :h1
   {:font-family "Vegan Sans !important"}]
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
     :font-weight 900
     :font-variant-caps :small-caps
     :color "#FDFDFD"
     :font-size (u/rem 7.27)}]]
  [:main
   {:text-align :center
    :margin-bottom (u/rem 2)}
   [:svg
    {:animation [[zoom-in (* 2 breath-time) 1 :ease :forwards]]
     :margin [[(u/rem 12) 0 0]]
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
     :margin-bottom [[(u/rem 4) "!important"]]}
    [:&>div.ui.cards
     {:justify-content :space-around}]
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
    :color "#FDFDFD"}]]
  (at-media {:screen true
             :max-width "694px"}
            [:header>h1 {:font-size [[(u/rem 6) "!important"]]}])
  (at-media {:screen true
             :max-width "507px"}
            [:header>h1 {:font-size [[(u/rem 5) "!important"]]}]
            [:main>svg {:margin-top [[(u/rem 2) "!important"]]}])
  (at-media {:screen true
             :max-width "438px"}
            [:html {:font-size (u/px 10)}]
            [:main>svg {:margin-top [[(u/rem 0) "!important"]]}])
  
  (at-media {:screen true
             :max-width "320px"}
            [:header>h1 {:font-size [[(u/rem 4) "!important"]]}]
            [:.ui.input>input {:width (u/rem 16)}]))
