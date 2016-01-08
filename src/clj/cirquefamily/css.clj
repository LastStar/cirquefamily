(ns cirquefamily.css
  (:refer-clojure :exclude [+ - * / rem])
  (:require [garden.units :as u :refer [px rem vh vw s]]
            [cirquefamily.colors :as c]
            [garden.arithmetic :refer [+ - * /]]
            [garden.def :refer [defstyles defkeyframes]]))

(def columns-count 12)
(def column (u/vw (/ 100 columns-count)))
(def sub-column (u/vw (/ 100 (* columns-count 4))))
(def one-quarter (u/vw (* 100 1/4)))
(def one-eighth (u/vw (* 100 1/8)))
(def center "translate(calc(50vw - 120px), calc(50vh - 120px))")

(defn scale [magnitude]
  (str "scale(" magnitude ")"))

(defkeyframes pulse
  [:0% {:transform [[center (scale 2)]]}]
  [:5% {:transform [[center (scale 2)]]}]
  [:90% {:transform [[center (scale 2.8)]]}]
  [:100% {:transform [[center (scale 2.8)]]}])

(def duration
  {:standart (s 1.42)
   :long (s 3)})

(defn transitional-prop
  ([p] (transitional-prop p :standart))
  ([p d]
   {:transition [[p (d duration) :ease-in-out]]}))

(defstyles screen
  pulse
  [:html
   {:font-size (u/pt 14)}]
  [:body
   {:margin 0
    :font-size (u/rem 1)}]
  [:div#app
   {:font-family "-apple-system-font, HelveticaNeue"}

   [:svg
    (transitional-prop :background-color :long)
    {:height (u/vh 92)
     :background-color c/white}
    [:circle
     {:cursor :pointer
      :fill :none
      :stroke-width 20
      :transform-origin :center
      :animation [[pulse (:standart duration) :infinite :alternate "cubic-bezier(0.45, 0.05, 0.55, 0.95)"]]}
     [:&.outer {:stroke c/blue}]
     [:&.center {:stroke c/green}]
     [:&.inner {:stroke c/red}]
     [:&.bullseye {:stroke c/white}]]]]
  [:div.header
   {:padding [[0 sub-column]]
    :color (c/black)}
   [:&>h1
    (transitional-prop :color :long)
    {:flex-grow 6
     :-webkit-flex-grow 6
     :font-size (u/rem (* 1.618 1.618))
     :font-weight 900}]
   [:&>div.navigation
    [:&>div>span
     (transitional-prop :color :standart)]
    [:&>a
     (transitional-prop :all :standart)
     {:font-weight :bold
      :text-decoration :none}
     [:&:hover
      {:transform (scale 1.42)}]]]]
  [:div.content
   {:padding [[0 sub-column]]}])
