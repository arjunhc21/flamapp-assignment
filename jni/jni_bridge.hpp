#pragma once
#include <vector>
#include <cstdint>

namespace flamapp {
    std::vector<uint8_t> process_gray(const uint8_t* src, int w, int h);
    std::vector<uint8_t> process_canny(const uint8_t* src, int w, int h);
    void release_resources();
}