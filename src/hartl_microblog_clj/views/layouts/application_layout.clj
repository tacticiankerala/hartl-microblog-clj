(ns hartl-microblog-clj.views.layouts.application-layout
  (:require [hiccup.page :as p]
            [hartl-microblog-clj.views.view-helper :as h]
            [hartl-microblog-clj.views.partials.navbar :as nav]))

(defn app-links []
  [{:title "Home" :href (h/url-for :hartl-microblog-clj.controllers.home-page-controller/index)}
   {:title "Login" :href (h/url-for :hartl-microblog-clj.controllers.login-controller/show-login)}])


(defn layout [view current-path]
  [:html
   [:head
    (p/include-css "assets/css/bootstrap/bootstrap.min.css" "assets/css/tether/tether.min.css" "assets/css/app.css")]
   [:body
    (p/include-js "assets/js/jquery/jquery-3.2.1.min.js" "assets/js/tether/tether.min.js" "assets/js/bootstrap/bootstrap.min.js")
    [:header
     (nav/navbar "Sample App" (app-links) current-path)]
    (view)]])
