(ns cirquefamily.css
  (:require [garden.def :refer [defstyles defkeyframes]]))

(defkeyframes pulse
  [:0% {:transform "translate(calc(50vw - 130px), calc(50vh - 120px)) scale(1.4)"}]
  [:5% {:transform "translate(calc(50vw - 130px), calc(50vh - 120px)) scale(1.4)"}]
  [:95% {:transform "translate(calc(50vw - 130px), calc(50vh - 120px)) scale(1.6)"}]
  [:100% {:transform "translate(calc(50vw - 130px), calc(50vh - 120px)) scale(1.6)"}])

(defstyles screen
  pulse
  [:body
   [:svg
    {:width "100vw"
     :height "100vh"}
    [:circle
     {:fill "none"
      :stroke-width "30"
      :transform-origin "center"
      :animation [[pulse "1.42s" :infinite :alternate]]}
     [:&.outer {:stroke "#1c6fc1"}]
     [:&.inner {:stroke "#9acc43"}]
     [:&.bullseye {:stroke "#ff7d00"}]]]])
