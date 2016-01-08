(ns cirquefamily.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [cirquefamily.core-test]))

(doo-tests 'cirquefamily.core-test)
