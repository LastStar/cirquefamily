(ns cirquefamily.handlers
    (:require [re-frame.core :as frame]
              [cirquefamily.db :as db]))

(frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(frame/register-handler
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(frame/register-handler
 :home-color-change
  frame/trim-v
  (fn [db [part]]
    (let [new-color (get-in db [:colors part])]
      (assoc db :home-color new-color))))
