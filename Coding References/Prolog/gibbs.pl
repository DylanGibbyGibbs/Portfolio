parent(david, ethan).
parent(david, ellen).
parent(david, eric).
parent(ellen, frank).
parent(eric, fine).
parent(frank, grace).
parent(frank, green).
parent(fine, glen).
parent(green, henry).
parent(peter, queen).
parent(queen, rose).
parent(grace, hellen).
parent(queen, rori).

ancestor(X, Y):-
    parent(X,Y).

ancestor(X,Y):-
    parent(X,Z),
    ancestor(Z,Y).

 descendent(X, Y) :-
    parent(Y, X).

descendent(X, Y) :-
    parent(Y, Z),
    descendent(X, Z).

descendent2(X, Y) :-
    ancestor(Y, X).

husband(henry, rose).
male(david).
male(frank).
male(fine).
male(henry).
male(glen).
male(eric).
male(ethan).
male(peter).
female(grace).
female(hellen).
female(green).
female(queen).
female(rose).
female(rori).
female(ellen).

%This is for the Girls side
motherinlaw1(X, Y) :-
    husband(Y, Z),
    parent(X, Z),
    female(X).
%This is for the Guys Side
motherinlaw2(X, Y) :-
    husband(Z, Y),
    parent(X, Z),
    female(X).

sister(X, Y) :-
    parent(Z, X),
    parent(Z, Y),
    female(X),
    X \= Y.

sibling(X, Y) :-
    parent(Z, X),
    parent(Z, Y),
    X \= Y.

nephew(X, Y) :-
    parent(Z, X),
    sibling(Z, Y),
    male(X).
