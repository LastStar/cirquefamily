(ns cirquefamily.css
  (:refer-clojure :exclude [+ - * / rem])
  (:require [garden.units :as u :refer [px rem vh vw s]]
            [cirquefamily.colors :as c]
            [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]))

(defn scale [magnitude]
  (str "scale(" magnitude ")"))

(defkeyframes pulse
  [:0% {:transform (scale 0.9)
        :-webkit-filter "blur(20px)"
        :opacity 0.1}]
  [:50% {:transform (scale 2.1)
         :-webkit-filter "blur(0px)"
         :opacity 1}]
  [:100% {:transform (scale 2.1)
         :opacity 1}])

(defkeyframes reveal
  [:0% {:-webkit-filter "blur(20px)"
        :opacity 0.1}]
  [:50% {:-webkit-filter "blur(0px)"
         :opacity 1}]
  [:100% {:opacity 1}])

(defstyles screen
  pulse
  reveal
  [:html
   {:font-size (u/pt 14)}]
  [:body
   {:font-family "VeganSuperiorMBL-Bold"
    :margin 0
    :font-size (u/rem 1)
    :background-color "#020202"}]
  [:header.ui.centered.grid
   {:padding [[(u/rem 4) 0]]}
   [:h1.ui.header
    {:animation [[reveal (u/s 3.24) :ease :forwards]]
     :font-family "VeganSuperiorMBL-Bold"
     :font-variant-caps :small-caps
     :color "#FDFDFD"
     :font-size "101.75px"}]]
  [:main
   [:svg
    {:animation [[pulse (u/s 3.24) 1 :ease :forwards]]
     :margin [[(u/rem 6) 0 (u/rem 12)]]
     :padding "0px !important"
     :cursor :pointer}]]
  [:footer
   {:font-family "VeganSuperiorMBL-Bold"
    :font-variant-caps :small-caps
    :position :relative
    :color "#FDFDFD"
    :bottom 0}])
