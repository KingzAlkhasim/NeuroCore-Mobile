# NeuroCore Mobile

**An offline-first Android AI assistant powered by Qwen, built by KingxTech.**

NeuroCore Mobile is being developed to bring private, on-device AI chat to Android. The goal is simple: install the app, open it, and chat—even without an internet connection.

> 🚧 **Status: Early development.** Features below describe the project direction; they are not all implemented yet.

## Vision

- **Local AI:** Run Qwen2.5-1.5B-Instruct on the device using a quantized GGUF model and a native inference runtime.
- **Offline by default:** No cloud inference, account, or API key required for core chat.
- **Rich responses:** Render Markdown correctly, including headings, lists, links, tables, inline formatting, and code blocks.
- **Developer-friendly code:** Syntax-highlighted code blocks with copy actions.
- **Read aloud:** Use Android Text-to-Speech (TTS) to speak assistant responses with an installed device voice.
- **Conversation history:** Keep chats on-device.
- **Customizable experience:** A polished dark interface, readable typography, and voice/speech settings.

## Planned technology

| Component | Technology |
| --- | --- |
| Android app | Kotlin |
| UI | Jetpack Compose |
| Local inference | llama.cpp (Android integration) |
| Model | Qwen2.5-1.5B-Instruct, Q4_K_M (planned) |
| Markdown | Native Markdown rendering solution |
| Text-to-Speech | Android TextToSpeech |
| Local chat storage | Room |

## Model and packaging

The intended experience is a **preloaded-model edition**: the model is bundled with the distributable so users can chat immediately after installation, without downloading model files in-app.

The model is roughly 1.1 GB in Q4_K_M format; final APK/AAB packaging, distribution limits, device compatibility, and memory/performance requirements will be evaluated during development. The model is not included in this source repository at this stage.

## Development

Development is planned around Android Studio and Gradle. GitHub Actions will be used to automate Android builds and publish test APK artifacts when the build pipeline is ready.

## Project status

- [ ] Android project scaffold
- [ ] Initial Compose chat UI
- [ ] Markdown rendering
- [ ] Code block rendering and copy action
- [ ] Android TTS playback controls
- [ ] Local conversation persistence
- [ ] llama.cpp Android integration
- [ ] Qwen model integration
- [ ] Offline inference testing
- [ ] Automated APK build workflow
- [ ] Device testing and performance tuning

## License

The project source code is intended to be licensed under the [Apache License 2.0](LICENSE). Model weights are distributed under their own license and terms; review the upstream Qwen license before redistributing model files.

## About KingxTech

NeuroCore Mobile is a KingxTech project focused on accessible, private, local-first AI experiences.

- Website: https://kingxtech.name.ng
- GitHub: https://github.com/KingzAlkhasim
