(ns quil-sketch.dynamic
  (:require [quil.core :as q]))

;; 1. lein repl
;; 2. (use :reload 'quil-sketch.dynamic')

;;50+sin(a)*40.0);
;;  a = a + inc

(defn setup []
  (q/smooth)
  (q/frame-rate 1)
  (q/background 100))

(defn draw []
  (q/background 255) ;; clear background everytime
  (q/stroke (q/random 250) (q/random 0) (q/random 200))
  (q/stroke-weight (q/random 20))
  ;; este es con opacidad y monochromatico
  ;; (q/fill (q/random 255) (q/random 200))
  (q/fill (q/random 255) (q/random 200) (q/random 200))

  (let [diam   (q/random 10)
        ;;twoPI  (/ (q/TWO-PI) 25)
        modFCC (mod (q/frame-count) (q/width))

        x    (q/random (/ (q/width) 2))
        nx   (- (q/width) x)
        y    (q/random (q/height))]

    #_q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
    #_(println x y)
    #_(println (q/frame-count))

    (q/ellipse x y diam diam)
    (q/line x y nx y)
    (q/ellipse nx y diam diam)))


 (defn reload [] (use :reload 'quil-sketch.dynamic))

 (defn clear []
  (q/background 0))
