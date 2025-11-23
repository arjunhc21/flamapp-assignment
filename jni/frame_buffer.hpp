#pragma once
#include <vector>
#include <cstdint>

struct frame_buffer {
    int width;
    int height;
    std::vector<uint8_t> data;

    frame_buffer() : width(0), height(0) {}
    frame_buffer(int w, int h) : width(w), height(h), data(w*h*3) {}
};