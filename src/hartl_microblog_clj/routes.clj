(ns hartl-microblog-clj.routes
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            [hartl-microblog-clj.pages :as pages]))

;; Defines "/" and "/about" routes with their associated :get handlers.
;; The interceptors defined after the verb map (e.g., {:get home-page}
;; apply to / and its children (/about).
(def common-interceptors [(body-params/body-params) http/html-body])


;; Tabular routes
(def routes #{["/" :get (conj common-interceptors `pages/home-page)]
              ["/about" :get (conj common-interceptors `pages/about-page)]})

;; Map-based routes
                                        ;(def routes `{"/" {:interceptors [(body-params/body-params) http/html-body]
                                        ;                   :get home-page
                                        ;                   "/about" {:get about-page}}})

;; Terse/Vector-based routes
                                        ;(def routes
                                        ;  `[[["/" {:get home-page}
                                        ;      ^:interceptors [(body-params/body-params) http/html-body]
                                        ;      ["/about" {:get about-page}]]]])
