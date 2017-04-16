(ns hartl-microblog-clj.controllers.login-controller
  (:require [hartl-microblog-clj.controllers.controller-helper :as helper]
            [hartl-microblog-clj.views.login :as login-page]))

(defn show-login [request]
  (helper/render `login-page/view request))
