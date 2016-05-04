(ns cirquefamily.views
    (:require [reagent.core :as r]))

(def state (r/atom :initial))

(defn logo
  "Renders logo"
  []
  (fn []
    [:svg.eight.wide.column
     {:width "351px"
      :height "351px"
      :viewBox "0 0 351 351"
      :version "1.1"
      :xmlns "http://www.w3.org/2000/svg"
      :xmlns:xlink "http://www.w3.org/1999/xlink"}
     [:desc "Created with Sketch."]
     [:defs]
     [:circle {:id "bg", :stroke "none", :fill "#FDFDFD", :fill-rule "evenodd", :cx "175.429687", :cy "175.429687", :r "175.429687"}]
     (cond
       (or (= @state :initial) (= @state :subscribing))
       [:path
        {:on-click #(reset! state :show-text)
         :d "M152.916,186.76 C152.296,197.796 148.7,203.624 139.896,203.624 C128.488,203.624 125.14,191.596 125.14,175.6 C125.14,159.604 129.356,147.576 139.896,147.576 C148.7,147.576 152.296,153.404 152.916,164.44 L176.228,164.44 C175.484,141.128 160.852,130.34 139.896,130.34 C116.46,130.34 100.96,148.196 100.96,175.6 C100.96,203.004 112.74,220.86 139.896,220.86 C160.852,220.86 175.484,210.072 176.228,186.76 L152.916,186.76 Z M211.568,219 L211.568,184.404 L240.708,184.404 L240.708,167.168 L211.568,167.168 L211.568,149.436 L243.188,149.436 L243.188,132.2 L188.628,132.2 L188.628,219 L211.568,219 Z"
         :id "CF"
         :stroke "none"
         :fill "#6A4C93"
         :fill-rule "evenodd"}]
       (= @state :show-text)
       [:g
        {:on-click #(reset! state :subscribing)
         :id "text"
         :stroke "none"
         :stroke-width "1"
         :fill "none"
         :fill-rule "evenodd"
         :transform "translate(89.000000, 90.000000)"}
        [:circle {:id "Oval-3", :fill "#FDFDFD", :cx "87.5", :cy "86.5", :r "86.5"}]
        [:text {:id "We-are", :font-family "VeganSuperiorMBL-Bold, Vegan Sans", :font-size "19.7999992", :font-weight "700"}
         [:tspan {:x "53.0677013", :y "39", :fill "#081019"} "We are"]
         [:tspan {:x "16.577", :y "60", :font-size "14", :fill "#081019"} " solving problems of "]
         [:tspan {:x "0.05", :y "78", :font-size "14", :fill "#081019"} "companies, "]
         [:tspan {:x "81.796", :y "78", :font-size "14", :fill "#08101A"} "corporations, "]
         [:tspan {:x "14.533", :y "96", :font-size "14", :fill "#081019"} "states and so on, but "]
         [:tspan {:x "7.694", :y "114", :font-size "14", :fill "#081019"} "maybe we should solve "]
         [:tspan {:x "11.278", :y "132", :font-size "14", :fill "#081019"} "our families problems"]
         [:tspan {:x "63.4726009", :y "158", :fill "#081019"} "first."]]]
       (= @state :parents)
       [:g {:id "parents", :stroke "none", :stroke-width "1", :fill "none", :fill-rule "evenodd", :transform "translate(89.000000, 90.000000)"}
        [:circle {:id "Oval-3", :fill "#FAFAFA", :cx "87.5", :cy "86.5", :r "86.5"}]
        [:text {:id "We-are", :font-family "VeganSuperiorMBL-Bold, Vegan Sans", :font-size "19.7999992", :font-weight "700", :fill "#081019"}
         [:tspan {:x "53.0677013", :y "36"} "We are"]
         [:tspan {:x "119.932299", :y "36", :font-size "14"}]
         [:tspan {:x "21.925", :y "60", :font-size "14"} " not without faults "]
         [:tspan {:x "15.604", :y "78", :font-size "14"} "and fails sometimes, "]
         [:tspan {:x "14.491", :y "96", :font-size "14"} "but we believe in our "]
         [:tspan {:x "24.172", :y "114", :font-size "14"} "kids as something "]
         [:tspan {:x "58.157", :y "132", :font-size "14"} "that will"]
         [:tspan {:x "66.1456008", :y "158"} "last."]]]
       :else
       [:g {:on-click #(reset! state :show-text)
            :id "parents"
            :stroke "none"
            :stroke-width "1"
            :fill "none"
            :fill-rule "evenodd"
            :transform "translate(89.000000, 90.000000)"}
        [:circle {:id "Oval-3", :fill "#FAFAFA", :cx "87.5", :cy "86.5", :r "86.5"}]
        [:text {:id "We-are", :font-family "VeganSuperiorMBL-Bold, Vegan Sans", :font-size "19.7999992", :font-weight "700", :fill "#081019"}
         [:tspan {:x "53.0677013", :y "36"} "We are"]
         [:tspan {:x "119.932299", :y "36", :font-size "14"}]
         [:tspan {:x "8.051", :y "60", :font-size "14"} " not without our faults "]
         [:tspan {:x "15.604", :y "78", :font-size "14"} "and fails sometimes, "]
         [:tspan {:x "14.491", :y "96", :font-size "14"} "but we believe in our "]
         [:tspan {:x "13.875", :y "114", :font-size "14"} "kids and they are the "]
         [:tspan {:x "9.332", :y "132", :font-size "14"} "daily first thought and "]
         [:tspan {:x "66.1456008", :y "150"} "last."]]])
     [:path {:d "M148.629845,18 C117.420615,23.3324248 87.5012933,38.0444348 63.4096982,62.1360298 C1.53010061,124.015627 1.53010061,224.342278 63.4096982,286.221875 C125.289296,348.101473 225.615946,348.101473 287.495544,286.221875 L287.495544,286.221875 C349.375141,224.342278 349.375141,124.015627 287.495544,62.1360298 C264.079556,38.7200423 235.158116,24.1649474 204.897882,18.4707452", :id "outer", :stroke "#FF595E", :stroke-width "18", :stroke-linecap "round", :fill "none"}]
     [:path {:d "M75.1912973,259.034471 C91.8508925,279.103932 114.67094,294.389625 141.782289,301.65409 C211.418169,320.312967 282.995212,278.987942 301.65409,209.352063 C320.312967,139.716183 278.987942,68.1391403 209.352063,49.4802626 L209.352063,49.4802626 C139.716183,30.8213849 68.1391403,72.14641 49.4802626,141.782289 C42.4195178,168.133348 43.9482103,194.762373 52.3500731,218.696702", :id "center", :stroke "#8AC926", :stroke-width "18", :stroke-linecap "round", :fill "none"}]
     [:path {:d "M268.339588,209.599127 C275.219291,191.004903 276.608612,170.173489 271.086779,149.565729 C256.903875,96.6344099 202.497048,65.2226134 149.565729,79.4055175 C96.6344099,93.5884217 65.2226134,147.995249 79.4055175,200.926568 L79.4055175,200.926568 C93.5884217,253.857887 147.995249,285.269683 200.926568,271.086779 C220.956419,265.719797 237.904766,254.592921 250.467049,239.965719", :id "inner", :stroke "#1982C4", :stroke-width "18", :stroke-linecap "round", :fill "none"}]]))

(defn home-panel []
  (fn []
    [:div.ui.container
     [:header.ui.centered.grid
      [:h1.ui.ten.wide.header "Cirque Family"]]
     [:main.ui.centered.grid
      [logo]
      (cond
        (= @state :subscribing)
        [:div.subscribe.ui.segment.fourteen.wide.column
         [:form
          [:div.ui.field
           [:h2.ui.header
            "In case you want to "
            [:em "join us"]
            " on our journey to family life embetterment"
            [:em " as a\u00A0volunteer"]
            ", give us"]
           [:div.ui.action.input.massive
            [:input
             {:placeholder "your email address"
              :on-focus #(-> js/document .-body (aset "className" "light"))
              :on-blur #(-> js/document .-body (aset "className" ""))}]
            [:button.ui.button.massive.orange " please"]]
           [:h4.ui.header "We will never spam you and first contact message will be written by human. So be patient please."]
           [:h4.ui.header "EU citizens are prefered for now, for logistical and operational reasons."]
           [:h4.ui.header "Czech and English are the only official languages, for now."]
           [:h4.ui.button.green
            {:on-click (fn []
                         (-> js/document .-body (aset "className" "light"))
                         (reset! state :parents))}
            "Parents of Cirque Family"]]]]
        (= @state :parents)
        [:div.ui.segment.fourteen.wide.column.grid
         [:div.parents.ui.cards
         [:div.ui.card
          [:div.ui.image
           [:img
           {:src "/img/vendi.jpg"}]]
          [:div.ui.content
           [:div.header "Vendula Pospíšilová"]
           [:p "Woman behind the steering wheel, loving mother, the great initiator and the light of the project"]]]
         [:div.ui.card
          [:div.ui.image
           [:img
            {:src "/img/pepe.jpg"}]]
          [:div.ui.content
           [:div.header "Josef Pospíšil"]
           [:p "Man behind the computer, loving father, metal dragon in both chinese calendar and humor."]]]
         [:div.ui.card
          [:div.ui.image
           [:img
            {:src "/img/mariana.jpg"}]]
          [:div.ui.content
           [:div.header "Mariana Klementová"]
           [:p "Woman behind the scene, loving mother, the great inspirator and the soul of the project"]]]]]
        :else
        [:div
         {:style {:display :none}}
         (-> js/document .-body (aset "className" ""))])]
     [:footer.ui.footer "\u00A9 Cirque Family 2016"]]))
