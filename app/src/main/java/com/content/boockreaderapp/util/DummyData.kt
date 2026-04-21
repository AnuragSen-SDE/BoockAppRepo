package com.content.boockreaderapp.util

import com.content.boockreaderapp.data.lolcal.entity.BookEntity

object DummyData {
    fun getDummyData() : List<BookEntity> {
        val book = BookEntity(
            title = "Book Title",
            author = "Author name",
            isStarted = false,
            content = ""
//                "Jetpack Compose has significantly transformed Android app development by shifting the paradigm from the traditional XML-based view system to a modern, declarative UI approach that emphasizes simplicity, scalability, and developer productivity. Instead of manually managing UI elements, layouts, and state synchronization as required in the classic View system, developers now describe the UI as a function of state, which automatically updates when the data changes. This reduces boilerplate code, minimizes the chances of UI inconsistencies, and makes the overall codebase easier to read, maintain, and test. By leveraging Kotlin’s expressive capabilities, Compose allows developers to build complex UIs with far fewer lines of code, improving both development speed and code clarity.\n" +
//                    "\n" +
//                    "One of the most impactful changes introduced by Jetpack Compose is its reactive programming model, which aligns closely with modern app architecture patterns such as MVVM and unidirectional data flow. This makes state management more predictable and reduces bugs caused by improper UI updates. Compose integrates seamlessly with other Jetpack libraries, enabling developers to build cohesive and robust applications without needing excessive glue code. Additionally, features like live previews, interactive UI inspection, and hot reload-like behavior in Android Studio significantly enhance the developer experience, allowing faster iteration and reducing the feedback loop during UI development.\n" +
//                    "\n" +
//                    "Performance is another area where Compose has made notable progress. Although early versions raised concerns, the framework has matured to provide efficient recomposition, meaning only the necessary parts of the UI are redrawn when state changes occur. This leads to smoother user experiences when implemented correctly. Compose also simplifies animations and theming, making it easier to create visually appealing and consistent designs across the app. The ability to reuse composable functions encourages modular design and promotes better code organization, which is especially beneficial in large-scale applications.\n" +
//                    "\n" +
//                    "From a team and business perspective, Jetpack Compose reduces development time and long-term maintenance costs. Since UI logic is centralized and less fragmented compared to XML and imperative UI code, onboarding new developers becomes easier. It also encourages best practices and modern development standards, helping teams stay aligned with the evolving Android ecosystem. While there is an initial learning curve, especially for developers accustomed to the traditional View system, the long-term benefits in productivity, code quality, and maintainability are substantial.\n" +
//                    "\n" +
//                    "Overall, Jetpack Compose represents a major evolution in Android development, bringing it closer to other modern UI frameworks like React and Flutter while retaining the flexibility and power of native Android. Its adoption is steadily growing, and it is becoming the preferred approach for building new Android applications, indicating a clear shift in how UI development is approached in the Android ecosystem."
        )

        val list : List<BookEntity> = MutableList<BookEntity>(20,{
            book
        })
        return list
    }
}