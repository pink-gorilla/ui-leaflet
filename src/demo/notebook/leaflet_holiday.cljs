
(def places
  {:london {:center [51.49, -0.08]
            :zoom 12
            :height 600 :width 700
            :features [{:type :rectangle
                        :bounds [[51.49, -0.08]
                                 [51.5, -0.06]]}]}
   :panama {:center [9.1880621 -82.0075993]
            :zoom 12
            :height 600 :width 700}
   :vienna {:center [48.2215786 16.2684791]
            :zoom 12
            :height 600 :width 700}})

(def holiday-state
  (r/atom {:place nil
           :map nil}))

(defn getdestination [place]
  (swap! holiday-state assoc :map (place places)))

(defn lucky []
  (let [ks (into [] (keys places))
        i (rand-int (count ks))
        place (get ks i)]
    (swap! holiday-state assoc :map (place places))))

^:R
[:div
 [:div {:class "flex flex-row content-between"}
  ['user/select
   {:items [:london :panama :vienna]
    :on-change getdestination}
   holiday-state [:place]]
  [:p/button {:on-click lucky} "Feeling Lucky!"]]
 [:p (str "map data: " (:map @holiday-state))]
 (when (:map @holiday-state)
   ['user/leaflet (:map @holiday-state)])]
