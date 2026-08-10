# D387 - Landon Hotel Scheduling: Multithreading & Cloud Deployment

A modification of the Landon Hotel scheduling application (Spring backend, Angular front end) to add internationalization, multithreading, and time zone support, then containerize the app with Docker.

## What This Project Demonstrates

- **Multithreaded Java**: displayed localized welcome messages using a separate thread per language.
- **Internationalization (i18n)**: built English and French resource bundles for locale-based content.
- **Time zone handling**: wrote a Java method to convert and display times across Eastern, Mountain, and UTC time zones.
- **Front-end localization**: updated the Angular UI to display reservation prices in USD, CAD, and EUR.
- **Containerization**: wrote a Dockerfile to package the full multithreaded Spring application into a single image, built and ran it in a named container.
- **Cloud deployment planning**: documented an approach for deploying the containerized application to a cloud provider.
- **Version control workflow**: used Git/GitLab with incremental, message-driven commits to track feature development end to end.

## Features Implemented

| Area | Description |
|---|---|
| Localized Welcome Message | English and French resource bundles, each rendered on its own thread |
| Currency Display | Reservation price shown in USD, CAD, and EUR |
| Time Zone Conversion | Java method converting and displaying ET, MT, and UTC for a live presentation time |
| Dockerfile | Single-image build containing all backend/frontend code and modifications |
| Containerized Run | Built and ran the image in a named Docker container |
| Cloud Deployment Plan | Written explanation of how the app would be deployed to a cloud provider |

## Tech Stack

- Java (multithreading, resource bundles)
- Spring Framework
- Angular
- Docker
- Git / GitLab

## What I Learned

- How to safely run concurrent tasks in Java using threads, and coordinate output from multiple threads.
- How to implement locale-aware content using Java resource bundles.
- How to reason about and convert between time zones programmatically.
- How to write a Dockerfile that packages a full-stack Spring + Angular application into a deployable image.
- How to build, run, and verify a containerized application.
- The basics of planning a cloud deployment strategy for a containerized service.
