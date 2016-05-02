(ns cirquefamily.views
    (:require [re-frame.core :as frame]
              [cirquefamily.svg :as svg]))

(defn home-panel []
  (fn []
    (let [show-subscribe (frame/subscribe [:show-subscribe])]
      [:div.ui.container
       [:header.ui.centered.grid
        [:h1.ui.ten.wide.header "Cirque Family"]]
       [:main.ui.centered.grid
        [svg/logo]
        (when @show-subscribe
          (-> js/document .-body (aset "className" "light"))
          [:form.ui.segment.fourteen.wide.column
           [:div.ui.field
            [:h2 "In case you want to join us, on our journey to family life embetterment as an volunteer helper, give us please"]
            [:div.ui.action.input.massive
             [:input
              {:placeholder "your email address."}]
             [:button.ui.button.massive.orange "Take it!"]]
            [:h4 "We will never spam you and first contact message will be written by human. So be patient please."]
            [:h4 "EU citizens are prefered for now, for logistical and operational reasons."]
]])]
       [:footer.ui.footer "\u00A9 Cirque Family 2016"]])))

;; main
(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (fn []
    (let [active-panel (frame/subscribe [:active-panel])]
      (panels @active-panel))))
