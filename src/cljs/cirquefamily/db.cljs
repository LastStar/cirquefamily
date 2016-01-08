(ns cirquefamily.db
  (:require [cirquefamily.colors :as c]))

(def default-db
  {:name "Cirque Family"
   :home-color c/white
   :colors {:bullseye c/white
            :inner c/red
            :center c/green
            :outer c/blue}})
