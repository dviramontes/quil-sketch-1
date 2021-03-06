(ns quil-sketch.dynamic
  (:require [quil.core :as q])
  #_(:use overtone.live)
  )

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


 ; (definst foo [] (saw 220))
 ; (definst trem [freq 440 depth 10 rate 6 length 3]
 ;    (* 0.3
 ;       (line:kr 0 1 length FREE)
 ;       (saw (+ freq (* depth (sin-osc:kr rate))))))


(defn setup 
  [rate]
    (q/smooth)
    (q/frame-rate (or rate 20))
    (q/background 150))

(defn draw []
  (q/background 255) ;; clear background everytime
  ;; este es con opacidad y monochromatico
  ;; (q/fill (q/random 255) (q/random 200))
  (q/fill (q/random 10) (q/random 10) (q/random 10))

  (let [diam   (q/random 7)
        horizon(/ (q/height) 2)
        twoPI  (/ q/TWO-PI 25)
        ;; modulated frame-count counter
        modFCC (- (mod (q/frame-count) (/ (q/width) 2)) 1) 

        x    (q/random (/ (q/width) 20))
        y    modFCC
        nx   (- (q/width) x)]

    #_(q/with-translation [(/ (q/width)  2)
                         (/ (q/height) 2)])
    (comment 
      (println x y)
      (println (q/frame-count)))

    #_(println modFCC)

    #_(q/stroke (q/random 200) (q/random 200) (q/random 200))
    
    #_(q/ellipse x y diam diam)
    #_(q/ellipse nx y diam diam)

    (q/scale 0.45)
    (q/translate 450 320)
    (doseq [x (range (q/width))]
      ; (q/rotate (q/sin x))
      (q/stroke (+ (* (q/sin x) 180) 10) (+ (* (q/sin x) 180) 100) (+ (* (q/sin x) 180) 255))
      (q/line 
        (+ x 300)
        (+ (* (q/sin x) (+ (q/height) modFCC)) (q/mouse-x) 50)
        (- x 300)
        (+ (* (q/sin x) (+ (q/height) modFCC)) (q/mouse-y) 50)))

    #_(q/line (/ (q/width) 2) (/ (q/height) 2) (q/random nx) (q/random y)))
    
    #_(trem 300 200 20 15)

    #_(cond (> (q/frame-count) 600) (q/sketch-stop)))

; (defn clear-sketch []
;   (q/background 100))
; (defn exd []
;   (q/sketch-stop))


