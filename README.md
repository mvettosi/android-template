# Matteo Vettosi's Android Template
A simple template for myself to have all my current approaches to Android development at hand when creating a new app.
This is free to be used but anyone else, and please, feedback is always welcome!
Feel free to reach me out by opening an issue here, e-mailing me on `matteo.vettosi@gmail.com` or adding me on discord: `Drackmord#9541`

## Currently included
- Clean Architecture
- Hilt dependency injection
- Gradle kotlin DSL
- Jetpack Compose
- Compose Navigation
- Spotless formatting ([ktfmt](https://github.com/facebookincubator/ktfmt)) with cross-platform git pre-commit hooks
- Unit and integration tests with Mockk
- Timber logger

## Future addition candidates
- Sample UI test
- Gradle dependencies version management
- versionName and versionCode build-time generation

## Package structure
This project is made up of two modules:
- `app` meant to contain classes and business logic that interfaces with the host OS and third party libraries
- `core` meant to contain all the internal business logic

### App package structure
Every class in the app module should follow this structure:
```
.
├── entrypoint
│   ├── receivers
│   │   └── <Broadcast Receivers here>
│   ├── services
│   │   └── <Other Services here>
│   ├── ui
│   │   └── <UI Classes and ViewModels here>
│   └── workers
│       └── <WorkManager Workers here>
└── framework
    └── <Implementation of DataSource interfaces here>
```

### Core package structure
Every class in the core module should follow this structure:
```
.
├── data
│   └── <Repositories and DataSource interfaces here>
├── domain
│   └── <Internal Model classes here>
└── usecases
    └── <UseCase Classes here>
```
