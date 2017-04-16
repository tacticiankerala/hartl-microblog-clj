(ns hartl-microblog-clj.views.partials.navbar
  (:require [clojure.string :as str]))

(defn- active-link? [{href :href} current-path]
  (= current-path href))


(defn- navbar-link [{title :title href :href :as link} current-path]
  (let [default-classes ["nav-link"]
        classes         (str/join " " (if (active-link? link current-path) (conj default-classes "active") default-classes))]
    [:li.nav-item
     [:a {:href href :class classes} title]]))

(defn- navbar-links [links current-path]
  (for [l links]
    (navbar-link l current-path)))

(defn navbar [title links current-path]
  [:nav.navbar.navbar-toggleable-md.navbar-light.bg-faded
   [:button.navbar-toggler.navbar-toggler-right {:type :button :data-toggle :collapse :data-target "#navbar-supported-content"}
    [:span.navbar-toggler-icon]]
   [:a.navbar-brand {:href "#"} title]
   [:div#navbar-supported-content.collapse.navbar-collapse
    [:ul.navbar-nav.mr-auto
     (navbar-links links current-path)]]])
