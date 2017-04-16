(ns hartl-microblog-clj.controllers.controller-helper
  (:require [ring.util.response :as ring-resp]
            [hiccup2.core :as hiccup]
            [hartl-microblog-clj.views.layouts.application-layout :as app-layout]))


(defn render
  ([view-symbol layout-symbol request]
   (let [view   (resolve view-symbol)
         layout (resolve layout-symbol)]
     (ring-resp/response (str (hiccup/html (layout view (:path-info request)))))))
  ([view-symbol request]
   (render view-symbol `app-layout/layout request)))
