(ns hartl-microblog-clj.service
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.secure-headers :as secure-headers]
            [hartl-microblog-clj.routes :as r]))


;; Consumed by hartl-microblog-clj.server/create-server
;; See http/default-interceptors for additional options you can configure
(def service {:env                     :prod
              ;; You can bring your own non-default interceptors. Make
              ;; sure you include routing and set it up right for
              ;; dev-mode. If you do, many other keys for configuring
              ;; default interceptors will be ignored.
              ;; ::http/interceptors []
              ::http/routes            r/routes

              ;; Uncomment next line to enable CORS support, add
              ;; string(s) specifying scheme, host and port for
              ;; allowed source(s):
              ;;
              ;; "http://localhost:8080"
              ;;
              ;;::http/allowed-origins ["scheme://host:port"]

              ;; Root for resource interceptor that is available by default.
              ::http/resource-path     r/static-resources-root

              ::http/secure-headers    {:content-security-policy-settings (secure-headers/content-security-policy-header {:default-src "'self'"})}

              ;; Either :jetty, :immutant or :tomcat (see comments in project.clj)
              ::http/type              :jetty
              ;;::http/host "localhost"
              ::http/port              8080
              ;; Options to pass to the container (Jetty)
              ::http/container-options {:h2c? true
                                        :h2? false
                                        ;:keystore "test/hp/keystore.jks"
                                        ;:key-password "password"
                                        ;:ssl-port 8443
                                        :ssl? false}})
