(ns cirquefamily.core
    (:require [reagent.core :as reagent]
              [cirquefamily.views :as views]
              [cirquefamily.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/home-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (mount-root))
