(ns cljtestbench.core
  (:require [clj-time.core :as c]
            [clj-time.format :as f]))

(defn start-of-interval [interval]
  (c/start interval))

(start-of-interval #t/int ["2014-10-10" "2014-10-30"])