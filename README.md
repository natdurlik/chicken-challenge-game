# Chicken Challenge
Small game with focus on using Design Patterns.
## About

## Design Patterns
  1. State - altering between game screens, such as Main Menu, Settings etc.
  2. Singleton - ensuring only one instance of Player class and providing global access to it.
  3. Template method - skeleton of algorithm in `render()` method - used in abstract class GameScreenState, subclasses override some steps.
  4. Composite - composing drawable objects (graphics) into tree structure.
  5. Prototype - used in spawning Vehicles on Road, radomly producing clones of generic prototypes in prototype registry (VehicleRegitry class, Vehicle has `clone()` method).
  6. Command - encapsulating commands, such as moving Player, allowing to easily change controls in settings.
  7. Decorator - attaching new behavior to Command in MenuButton class.
  8. Adapter - adapting Command to Drawable interface.
  9. Strategy - family of interchangeable driving algorithms for Vehicle objects.
  10. Observer - Road (Observable) is notyfing Vehicles (Observer) about certain evens, allowing Vehicles to change their behavior. 
  11. Flyweight - all instances of MovingSnowflake class share common parts. 
  (12. (Null Object - NullCommand class used instead of checking if object is null)
  
  

