# Co-vivre

Inspiration
We wanted to make a website for Montrealers that gathers everything they need to know about Covid without having to search on Google multiple times. The name Co-Vivre pronounces similarly to covid and it is half English and half French: we hope that everyone can stay together and survive through this difficult pandemic.

What it does
The website shows the daily confirmed cases, total confirmed, recovered and death cases of covid in Montreal give a brief introduction to the three vaccines available in Montreal, and also a set of links to some websites containing useful information on covid. The website also contains a mini report on self-test positive cases, which is not included in the official website.

How we built it
On the backend, we used the spring-boot framework to build APIs. Once the front end sends the request, the back end grabs the data from the government site and sends it to the front. for the web crawler, We used the HttpClient and JSoup framework. HttpClient is used to grab the web page HTLM, JSoup is responsible for parsing the HTML page, so as to get the information we need.

Challenges we ran into
One of the biggest challenges that we have had is to connect the backend and the frontend. We did several searches on Google; however, all of them are based on either vue.js or reactr.js. Unfortunately, we are familiar with none of them. In the end, with the help of a mentor, we solve the problem by using Axios.

Accomplishments that we're proud of
First Web crawler that we implemented and it works well; first app with both backend and frontend connected without any provided code.

What we learned
Used of JSoup; a deeper understanding of Axios API; Build spring project with Maven instead of Gradle.

What's next for Co-Vivre (goal for next time)
We aimed to have a database connection for our website so that we can store the self-test positive cases; in addition, more useful information (such as the latest decision by the government) will be added to the website and if possible, rebuild the website with react framework.
