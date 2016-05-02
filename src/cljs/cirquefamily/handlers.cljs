(ns cirquefamily.handlers
    (:require [re-frame.core :as frame]
              [cirquefamily.db :as db]))

(frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(frame/register-handler
 :set-active-panel
 frame/trim-v
 (fn [db [active-panel]]
   (assoc db :active-panel active-panel)))

(frame/register-handler
 :logo-clicked
 (fn [db _]
   (assoc db :logo-clicked true)))

(frame/register-handler
 :show-subscribe
 (fn [db _]
   (assoc db :show-subscribe true)))
