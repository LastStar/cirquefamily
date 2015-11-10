(ns cirquefamily.css
  (:refer-clojure :exclude [+ - * / rem])
  (:require [garden.units :as u :refer [px rem vh vw s]]
            [cirquefamily.colors :as c]
            [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]))

(def center "translate(calc(50vw - 130px), calc(50vh - 120px))")

(defn scale [magnitude]
  (str "scale(" magnitude ")"))

(defkeyframes pulse
  [:0% {:transform [[center (scale 1.8)]]}]
  [:5% {:transform [[center (scale 1.8)]]}]
  [:95% {:transform [[center (scale 2.4)]]}]
  [:100% {:transform [[center (scale 2.4)]]}])

(def standart-time (s 1.42))

(defstyles screen
  pulse
  [:body
   {:margin 0}
   [:svg
    {:width (vw 100)
     :height (vh 100)
     :opacity 0.85
     :background-color c/white
     :transition [[:background-color standart-time]]}
    [:circle
     {:cursor :pointer
      :fill :none
      :stroke-width 25
      :transform-origin :center
      :opacity 0.75
      :animation [[pulse standart-time :infinite :alternate]]}
     [:&.outer {:stroke c/green}]
     [:&.central {:stroke c/orange}]
     [:&.inner {:stroke c/blue}]
     [:&.bullseye {:stroke c/white}]]]])
