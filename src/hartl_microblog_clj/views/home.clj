(ns hartl-microblog-clj.views.home
  (:require [hartl-microblog-clj.views.view-helper :as h]))

(defn view []
  [:div.container
   [:h1 "Welcome to the Sample App"]
   [:p "This is the home page for the sample app"]
   [:a.btn.btn-primary {:href (h/url-for :hartl-microblog-clj.controllers.login-controller/show-signup)} "Sign Up"]])
