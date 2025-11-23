#pragma once
#include <vector>
#include <cstdint>

namespace image_ops {
    std::vector<uint8_t> rgb_to_gray(const uint8_t* in, int w, int h);
    std::vector<uint8_t> canny(const uint8_t* in, int w, int h);
}