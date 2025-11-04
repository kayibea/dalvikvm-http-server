JAVAC  := javac
D8     := d8

PLATFORM_V := android-36
PLATFORM := $(HOME)/AndroidX/Sdk/platforms/$(PLATFORM_V)/android.jar
JAVA_VER := 11
JAR_FILE := minhttp.jar

ANDROID_TMPDIR := /data/local/tmp

all:
	$(JAVAC) --release $(JAVA_VER) MiniHTTP.java
	$(D8) --release --output $(JAR_FILE) MiniHTTP.class --lib $(PLATFORM)

push:
	adb push $(JAR_FILE) $(ANDROID_TMPDIR)

run:
	adb shell dalvikvm -cp $(ANDROID_TMPDIR)/$(JAR_FILE) MiniHTTP

clean:
	rm -f *.class *.jar

.PHONY: all push run clean
