(defproject cirquefamily "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [reagent "0.6.0-alpha"]
                 [re-frame "0.7.0-alpha"]
                 [secretary "1.2.3"]
                 [garden "1.3.0"]
                 [compojure "1.4.0"]
                 [ring "1.4.0"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-2"]
            [lein-garden "0.2.6"]
            [lein-doo "0.1.6"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"
                                    "resources/public/css/compiled"]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler cirquefamily.handler/handler}

  :garden {:builds [{:id "screen"
                     :source-paths ["src/clj" "src/cljc"]
                     :stylesheet cirquefamily.css/screen
                     :compiler {:output-to "resources/public/css/compiled/screen.css"
                                :pretty-print? true}}]}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs" "src/cljc"]
                        :figwheel {:on-jsload "cirquefamily.core/mount-root"}
                        :compiler {:main cirquefamily.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true}}

                       {:id "test"
                        :source-paths ["src/cljs" "test/cljs" "src/cljc"]
                        :compiler {:output-to "resources/public/js/compiled/test.js"
                                   :main cirquefamily.runner
                                   :optimizations :none}}

                       {:id "min"
                        :source-paths ["src/cljs" "src/cljc"]
                        :compiler {:main cirquefamily.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :closure-defines {goog.DEBUG false}
                                   :pretty-print false}}]})
