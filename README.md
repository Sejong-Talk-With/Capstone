# Capstone
- Edge Computing을 통한 실시간 혼잡도 측정

#### CLI - Cloud Setting

1. Upgrade apt-get and install idk ( For ubuntu )

```shell
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install openjdk-11-jdk
```



2. Env setting

```shell
sudo vi ~/.bashrc
```

위의 커맨드를 통해서 bashrc 수정

```shell
export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
export PATH=$PATH:$JAVA_HOME/bin

# 환경변수 세팅
export key=value
```

주로 사용하는 vim command

dd - 한줄 삭제

i - 수정 하겠습니다.

esc - 현재 상태 종료 ( i 입력 후 수정 그만하고 싶을 때 )

wq - 저장 후 종료

ZZ - wq와 동일 ( 더 편해서 제가 많이 사용합니다. )

```shell
source ~/.bashrc
```

수정 완료시, 위의 커맨드로 bashrc실행 ( 컴퓨터 다시시작이라고 생각하면 편함 )



3. Install Gradle

```shell
VERSION=7.1.1
wget https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip -P /tmp
```

<br>

```shell
sudo apt-get install unzip
sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
sudo ln -s /opt/gradle/gradle-${VERSION} /opt/gradle/latest
```

<br>

```shell
sudo vi /etc/profile.d/gradle.sh
```

위의 코드를 통해 아래 코드 기입 ( env단계에서 했던 것 과 동일 )

```shell
export GRADLE_HOME=/opt/gradle/latest
export PATH=${GRADLE_HOME}/bin:${PATH}
```

위의 작업 완료 시 아래 코드를 통해서 모드 변경 및 실행

```shell
sudo chmod +x /etc/profile.d/gradle.sh
source /etc/profile.d/gradle.sh
```



4. Build

```shell
gradle build
```

빌드 단계에서 어플리케이션에 따라 빌드시간 차이가 있습니다.



5. Run

```shell
java -jar build/libs/[jar파일]
```

<br>
