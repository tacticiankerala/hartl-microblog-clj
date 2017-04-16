(ns hartl-microblog-clj.views.view-helper
  (:require [io.pedestal.http.route :as route]))

(defn url-for [namespaced-keyword]
  (route/url-for namespaced-keyword))
