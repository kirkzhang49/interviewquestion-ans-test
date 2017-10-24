let rec fib = n match with
    | 1 ->1
    | 2 ->1
    | _ -> fib n-1 + fib n-2

    int fib (int x)
    {
     if (x ==1)
     return 1;
     else if (x==2)
     return 1;
     else return fib(x-1)+fib(x-2);
     }

Ocaml syntax |0|

(* *) = comment
Example Program:
#let average a b = 
    (a+.b) /. 2.0;; (* end of block*)
    val average: float -> float -> float = <fun> (* define types for the function a,b , return val*)

    t. /. = float operator (* + float / float  not dot one is int operator int cant operator with float*)
    turn to float 
    float @ int for example
    float_of_int a 
    float a 

let rec range a b = 
    if a > b then []
    else a :: range (a+1) b;; (a :: means append )

    int -> int -> intlist
(* Ocaml don't do any auto casting*)
special Ocaml stuff
'a , 'b ,'c -> any type
'a -> int ->' alist 
any for parm 1 int for parm2 listofanything for return val

hd = head 
tl = tail 

let average a b = 
    let sum = a +b in 
    sum ./ 2.0;;
float -> float -> float

list of stuff  = input 
    int n = input
    output = nth element in the List

lista = [1,apple,a,3,banana] 
        0    1   2 3   4
      
        n = 2
        expected output: a 
let rec findelement a n:
    match n with 
    | 0 -> hd
    | _ -> findelement n-1 tail;;

let rec nth lst n = 
    (* if(length lst) = 0 then (eqviv of blow up )*)
    if (length lst) = 0 then [] 
    if n = 0 then hd lst
    else nth (tl lst) n-1;; (* if n return hd of list else return rec rest of list find n-1 *)
    
val nth: 'alist ->int ->'a =<fun> (*any list, int ,any type* [a] = [a] ok, [a]==[a] no need to be abs equal include memory )

start - > drink&Entree | dessert 
every word is symbol 
nonterminal :  can expend 
terminal : can't expend any more 

isvalid?
cola pizza 
cake 
water cake 