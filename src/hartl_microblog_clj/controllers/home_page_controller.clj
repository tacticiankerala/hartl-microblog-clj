(ns hartl-microblog-clj.controllers.home-page-controller
  (:require [hartl-microblog-clj.controllers.controller-helper :as helper]
            [hartl-microblog-clj.views.home :as home-page]))

(defn index
  [request]
  (helper/render `home-page/view request))
