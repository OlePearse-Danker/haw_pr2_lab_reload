# UML Diagram

For subpackage `graphicState`.

____

````mermaid
classDiagram
direction BT
class InsideState {
  - InsideState instance
  + getInstance(Scene) InsideState
  + drawInside() State
  + drawOutside() State
}
class OutsideState {
  - OutsideState instance
  + drawOutside() State
  + drawInside() State
  + getInstance(Scene) OutsideState
}
class PoopState {
    - PoopState instance
    + drawOutside() State
    + drawInside() State
    + getInstance(Scene) PoopState
}

class State {
    <<abstract>>
  # Scene context
  # OutsideState outside
  # InsideState inside
  # PoopState poop
  + abstract drawOutside() State
  + abstract drawInside() State
  + abstract drawPoop() State
}

InsideState  --|>  State 
OutsideState  --|>  State 
PoopState --|> State

````