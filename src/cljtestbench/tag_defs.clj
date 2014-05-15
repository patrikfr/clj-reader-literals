(ns cljtestbench.tag-defs
  (:import (org.joda.time DateTime Interval))
  (:require [clj-time.core :as c]
            [clj-time.format :as f]))

(defn unparse [dt]
  (f/unparse (f/formatters :year-month-day) dt))

(defn interval [[from to]]
  (c/interval (f/parse from) (f/parse to)))

(defmethod print-method Interval [i ^java.io.Writer w]
  (.write w (str "#t/int [\"" (unparse (c/start i)) "\" \"" (unparse (c/end i)) "\"]")))

(defmethod print-dup Interval [o w]
  (print-method o w))



(defn date-time [dt]
  (f/parse dt))

(defmethod print-method DateTime [dt ^java.io.Writer w]
  (.write w (str "#t/dt \"" (unparse dt) "\"")))

(defmethod print-dup DateTime [o w]
  (print-method o w))