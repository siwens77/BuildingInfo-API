![Java CI](https://github.com/martyna188/BuildingInfo-Project/actions/workflows/ci.yml/badge.svg)

# Building Info API

**Building Info** is a building management system available as a remote REST API. It allows building administrators to minimize building management costs by enabling the extraction of detailed information about building parameters at the level of rooms, floors, and entire buildings. 

## Skills & Technologies Demonstrated
- **Java & Object-Oriented Programming**: Designed and developed robust backend logic using Java.
- **Agile Methodology**: The entire project was developed using the **Scrum** framework, successfully planning and delivering features across two distinct sprints.
- **Spring Boot**: Developed a RESTful API to expose building data parameters, allowing integration with existing tools.
- **Design Patterns**:
  - **Composite Pattern**: Used to model the hierarchical data structure of buildings containing levels, and levels containing rooms.
  - **Visitor Pattern**: Implemented to separate algorithms (e.g., area, cubature, heating, and lighting calculations) from the object structure on which they operate.
- **Testing**: Ensured code reliability with automated tests using JUnit and JSONPath.
- **Build & Dependency Management (Maven)**: Handled project dependencies, lifecycles, and build automation, including automated Javadoc generation.
- **CI/CD (GitHub Actions)**: 
  - Automated continuous integration pipelines for validating, building, and running tests on every push.
  - Automated GitHub Releases for tagged versions.
  - Configured deployment of Javadoc documentation directly to GitHub Pages.
## Data Structure Overview
The application processes locations with a highly scalable data model:
- **Location Hierarchy**: A location can be a Building, Level, or Room.
- **Composition**: A Building consists of Levels, and Levels consist of Rooms.
- **General Location Properties**:
  - `id`: Unique identifier
  - `name`: Optional name of the location
- **Room-Specific Properties**:
  - `area`: Area in m²
  - `cube`: Room volume in m³
  - `heating`: Level of heating energy consumption (float)
  - `light`: Total lighting power
## Integration & Extensibility
Thanks to the robust API design and the use of the Visitor design pattern, adding new types of calculations or locations can be done without modifying the existing domain models, adhering to the Open/Closed Principle.
