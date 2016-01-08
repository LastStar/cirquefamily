(ns cirquefamily.svg
  (:require [re-frame.core :as frame]))

(defn home [background]
  (let [dispatcher (fn [part] (frame/dispatch [:home-part-changed-to part]))]
    [:svg
     {:style {:background-color background}}
     [:circle.bullseye
      {:cx 120 :cy 120 :r 10
       :on-click #(dispatcher :bullseye)}]
     [:circle.inner
      {:cx 120 :cy 120 :r 25
       :on-click #(dispatcher :inner)}]
     [:circle.center
      {:cx 120 :cy 120 :r 50
       :on-click #(dispatcher :center)}]
     [:circle.outer
      {:cx 120 :cy 120 :r 75
       :on-click #(dispatcher :outer)}]]))
