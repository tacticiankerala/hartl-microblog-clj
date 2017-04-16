(ns hartl-microblog-clj.controllers.login-controller
  (:require [hartl-microblog-clj.controllers.controller-helper :as helper]
            [hartl-microblog-clj.views.login :as login-page]
            [hartl-microblog-clj.views.signup :as signup-page]))

(defn show-login [request]
  (helper/render `login-page/view request))

(defn show-signup [request]
  (helper/render `signup-page/view request))
