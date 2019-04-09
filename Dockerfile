FROM oracle/graalvm-ce:1.0.0-rc14 as graalvm
COPY . /home/app/prometheus
WORKDIR /home/app/prometheus
RUN native-image --no-server -cp build/libs/prometheus-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/prometheus .
ENTRYPOINT ["./prometheus"]
