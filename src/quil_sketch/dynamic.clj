(ns quil-sketch.dynamic
  (:require [quil.core :as q])
  (:use overtone.live))

;; 1. lein repl
;; 2. (use :reload 'quil-sketch.dynamic')

;;float a = 0.0;
;;float inc = TWO_PI/25.0;

;;for (int i = 0; i < 100; i=i+4) {
;;  line(i, 50, i, 50+sin(a)*40.0);
;;  a = a + inc;
;;}


 (defn reload [] (use :reload 'quil-sketch.dynamic))
 ;; (use 'overtone.live)
 ;; (definst foo [] (saw 220))
 ;; (kill # ) || (kill foo) ;; all instances of foo
 (definst foo [] (saw 220))

 (definst trem [freq 440 depth 10 rate 6 length 3]
    (* 0.3
       (line:kr 0 1 length FREE)
       (saw (+ freq (* depth (sin-osc:kr rate))))))


(defn setup 
  ([]
    (q/smooth)
    (q/frame-rate 20)
    (q/background 150))
  ([rate]
    (q/smooth)
    (q/frame-rate rate)
    (q/background 150)))

(defn draw []
  (q/background 255) ;; clear background everytime
  ;; este es con opacidad y monochromatico
  ;; (q/fill (q/random 255) (q/random 200))
  (q/fill (q/random 10) (q/random 10) (q/random 10))

  (let [diam   (q/random 10)
        horizon(/ (q/height) 2)
        twoPI  (/ q/TWO-PI 25)
        ;; modulated frame-count counter
        modFCC (- (mod (q/frame-count) (/ (q/width) 2)) 25) 

        x    (q/random (/ (q/width) 20))
        y    modFCC
        nx   (- (q/width) x)]

    #_(q/with-translation [(/ (q/width)  2)
                         (/ (q/height) 2)])
    (comment 
      (println x y)
      (println (q/frame-count)))

    #_(println modFCC)

    (q/stroke (q/random 250) (q/random 200) (q/random 255))
    (q/stroke-weight (q/random 2))
    (q/ellipse x y diam diam)
    (q/ellipse nx y diam diam))

    (doseq [x (range (q/width))]
      (q/line 
      x
      (q/frame-count)
      x
      (+ (* (q/sin (mod x 10)) 55) 100))
    )

    #_(q/line (/ (q/width) 2) (/ (q/height) 2) (q/random nx) (q/random y))
    
    #_(trem 300 200 20 15)

    #_(cond (> (q/frame-count) 600) (q/sketch-stop))
  )

; (defn exd []
;   (q/sketch-stop))

 (defn clear-sketch []
  (q/background 100))
