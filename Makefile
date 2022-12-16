docs:
	./gradlew javadoc
	pnpx serve build/docs

run: ./gradlew run