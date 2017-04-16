(ns hartl-microblog-clj.routes
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            [hartl-microblog-clj.controllers.home-page-controller :as home-page-controller]
            [hartl-microblog-clj.controllers.login-controller :as login-controller]))

(def static-resources-root "/public")

;; Defines "/" and "/about" routes with their associated :get handlers.
;; The interceptors defined after the verb map (e.g., {:get home-page}
;; apply to / and its children (/about).
(def common-interceptors [(body-params/body-params) http/html-body])


;; Tabular routes
(def routes #{["/" :get (conj common-interceptors `home-page-controller/index)]
              ["/login" :get (conj common-interceptors `login-controller/show-login)]})

;; Map-based routes
                                        ;(def routes `{"/" {:interceptors [(body-params/body-params) http/html-body]
                                        ;                   :get home-page
                                        ;                   "/about" {:get about-page}}})

;; Terse/Vector-based routes
                                        ;(def routes
                                        ;  `[[["/" {:get home-page}
                                        ;      ^:interceptors [(body-params/body-params) http/html-body]
                                        ;      ["/about" {:get about-page}]]]])
