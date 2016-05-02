(ns cirquefamily.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]
              ))

(re-frame/register-sub
 :name
 (fn [db]
   (reaction (:name @db))))

(re-frame/register-sub
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))

(re-frame/register-sub
 :logo-clicked
 (fn [db _]
   (reaction (:logo-clicked @db))))

(re-frame/register-sub
 :show-subscribe
  (fn [db _]
    (reaction (:show-subscribe @db))))
