# Emojis

This application was developed to demonstrate the process of Dependency Injection and the use of Dagger2.

Changes were made gradually, the process of dependency injection can be tracked in accordance with the order of the branches

1. [hard_di](https://github.com/GSench/Emojis/tree/hard_di) Initially the app was implemented using CleanArchitecture(MVP) approach. Dependencies were injected hard: each object creates its own dependencies
2. [di](https://github.com/GSench/Emojis/tree/di) The first step of DI was Constructor Injection, so now dependencies are provided as parameters.
3. [lifecycle_di](https://github.com/GSench/Emojis/tree/lifecycle_di) The next step is attaching dependencies to Android objects' lifecycle.
4. [manual_di](https://github.com/GSench/Emojis/tree/manual_di) The final step is creating Components hierarchy. Each Component is responsible for providing and storing dependencies for top-level Android objects, like Activity or Fragment. This is the last step of manual DI implementation.
5. [dagger_di](https://github.com/GSench/Emojis/tree/dagger_di) In the last branch I integrated Dagger2 and injected dependencies with this framework.

